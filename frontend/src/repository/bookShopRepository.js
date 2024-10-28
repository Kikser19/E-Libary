import axios from "../custom-axios/axios";
import data from "bootstrap/js/src/dom/data";

const BookShopService = {
    fetchCategories: () => {
        return axios.get("/categories")
    },
    fetchCountries: () => {
        return axios.get("/countries")
    },
    deleteBook: (id) => {
        return axios.delete(`/books/delete/${id}`);
    },
    deleteAuthor: (id) => {
        return axios.delete(`/authors/delete/${id}`);
    },
    fetchBooks: () => {
        return axios.get("/books")
    },
    fetchSearchedBooks: (title) => {
        return axios.get(`/books/search/${title}`)
    },
    fetchAuthors: () => {
        return axios.get("/authors")
    },
    addBook: (name, bookCategoryId, authorId, availableCopies,isbn) => {
        return axios.post("/books/add", {
            "name" : name,
            "bookCategoryId" : bookCategoryId,
            "authorId": authorId,
            "availableCopies": availableCopies,
            "isbn": isbn
        });
    },
    addAuthor: (name, surname, countryId, biography, dateOfBirth) => {
        return axios.post("/authors/add", {
            "name" : name,
            "surname" : surname,
            "countryId": countryId,
            "biography": biography,
            "dateOfBirth": dateOfBirth
        });
    },
    editBook: (id, name, bookCategoryId, authorId, availableCopies, isbn) => {
        return axios.put(`/books/edit/${id}`, {
            "name" : name,
            "bookCategoryId" : bookCategoryId,
            "authorId": authorId,
            "availableCopies": availableCopies,
            "isbn": isbn
        });
    },
    getBook: (id) => {
        return axios.get(`/books/${id}`)
    },
    markBook: (id) => {
        return axios.post(`/books/mark/${id}`);
    }
}

export default BookShopService;