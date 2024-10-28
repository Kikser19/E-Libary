import './App.css';
import React, {Component} from "react";
import Categories from "../Categories/categories";
import Countries from "../Countries/countriesList"
import BookShopService from "../../repository/bookShopRepository";
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom'
import Header from "../Header/header";
import Authors from "../Authors/AuthorsList/authors";
import Books from "../Books/BookList/books";
import BookAdd from "../Books/BookAdd/bookAdd"
import BookEdit from "../Books/BookEdit/bookEdit";
import axios from "axios";
import AuthorAdd from "../Authors/AuthorsAdd/authorAdd";
import Login from "../Authentication/Login";
import SignUp from "../Authentication/SignUp";



class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            categories: [],
            books: [],
            authors: [],
            countries:[],
            selectedBooks: {},
            searchQuery: '',
            searchResults: [],
            error: null
        }
    }

    handleSearch = async () => {
        try {
            const response = await axios.get(`/books/search?title=${this.state.searchQuery}`);
            this.setState({
                searchResults: response.data,
                error: null
            });
        } catch (error) {
            console.error('Error searching books:', error);
            this.setState({error: 'An error occurred while searching for books.'});
        }
    };

    render() {
        return (
            <div>
                <Router>
                    <Header/>
                    <main>
                        <div className={"container"}>
                            <Routes>
                                <Route path={"/categories"} element={<Categories categories={this.state.categories}/>}/>
                                <Route path={"/authors"} element={<Authors authors={this.state.authors}
                                                                           onDelete={this.deleteAuthor}/>}/>
                                <Route path={"/countries"} element={<Countries countries={this.state.countries}/>}/>
                                <Route path={"/books"}
                                       element={<Books books={this.state.books} onDelete={this.deleteBook}
                                                       onEdit={this.getBook} onMark={this.markBook}/>}/>
                                <Route path={"/books/add"}
                                       element={<BookAdd authors={this.state.authors} categories={this.state.categories}
                                                         onAddBook={this.addBook}/>}/>
                                <Route path={"/authors/add"}
                                       element={<AuthorAdd authors={this.state.authors}
                                                           countries={this.state.countries}
                                                         onAddAuthor={this.addAuthor}/>}/>
                                <Route path={"/"} element={<Books books={this.state.books} onDelete={this.deleteBook}
                                                                  onEdit={this.getBook} onMark={this.markBook}/>}/>
                                <Route path={"/books/edit/:id"} element={<BookEdit authors={this.state.authors}
                                                                                   categories={this.state.categories}
                                                                                   book={this.state.selectedBooks}
                                                                                   onEditBook={this.editBook}/>}/>
                                <Route path="/login" element={<Login />} />
                                <Route path="/register" element={<SignUp />} />
                            </Routes>
                        </div>
                    </main>
                </Router>
            </div>
        );
    }

    componentDidMount() {
        this.fetchData()
    }

    fetchData = () => {
        this.loadAuthors();
        this.loadCategories();
        this.loadBooks();
        this.loadCountries();
    }

    loadCategories = () => {
        BookShopService.fetchCategories()
            .then((data) => {
                this.setState({
                    categories: data.data
                })
            })
    }
    loadBooksSearched = (title) => {
        BookShopService.fetchSearchedBooks()
            .then((data) =>{
                this.setState({
                    searchResults: data.data
                })
                this.loadBooksSearched(title)
            })
    }

    loadBooks = () => {
        BookShopService.fetchBooks()
            .then((data) => {
                this.setState({
                    books: data.data
                })
            });
    }

    loadCountries= () => {
        BookShopService.fetchCountries()
            .then((data) => {
                this.setState({
                    countries: data.data
                })
            });
    }

    loadAuthors = () => {
        BookShopService.fetchAuthors()
            .then((data) => {
                this.setState({
                    authors: data.data
                })
            });
    }


    deleteBook = (id) => {
        BookShopService.deleteBook(id)
            .then(() => {
                this.loadBooks();
            })
    }

    deleteAuthor = (id) => {
        BookShopService.deleteAuthor(id)
            .then(() => {
                this.loadAuthors();
            })
    }

    markBook = (id) => {
        BookShopService.markBook(id)
            .then(() => {
                this.loadBooks();
            })
    }

    addBook = (name, bookCategoryId, authorId, availableCopies, isbn) => {
        BookShopService.addBook(name, bookCategoryId, authorId, availableCopies, isbn)
            .then(() => {
                this.loadBooks();
            });
    }

    addAuthor = (name, surname, countryId, biography, dateOfBirth) => {
        BookShopService.addAuthor(name, surname, countryId, biography, dateOfBirth)
            .then(() => {
                this.loadAuthors();
            });
    }

    getBook = (id) => {
        BookShopService.getBook(id)
            .then((data) => {
                this.setState({
                    selectedBooks: data.data
                })
            })
    }

    editBook = (id, name, bookCategoryId, authorId, availableCopies, isbn) => {
        BookShopService.editBook(id, name, bookCategoryId, authorId, availableCopies, isbn)
            .then(() => {
                this.loadBooks();
            });
    }

}

export default App;
