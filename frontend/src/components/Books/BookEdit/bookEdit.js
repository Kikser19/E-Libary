import React from "react";
import {useNavigate} from 'react-router-dom';

const BookEdit = (props) => {
    const navigate = useNavigate();
    const [formData, updateFormData] = React.useState({
        name: "",
        bookCategoryId: 1,
        authorId: 1,
        availableCopies: 0,
        isbn: 0
    })

    const handleChange = (e) => {
        updateFormData({
            ...formData,
            [e.target.name]: e.target.value.trim()
        })
    }

    const onFormSubmit = (e) => {
        e.preventDefault();
        const name = formData.name !== "" ? formData.name : props.book.name;
        const bookCategoryId = formData.bookCategoryId !== 0 ? formData.bookCategoryId : props.book.bookCategoryId;
        const authorId = formData.authorId !== 0 ? formData.authorId : props.book.authorId;
        const availableCopies = formData.availableCopies !== 0 ? formData.availableCopies : props.book.availableCopies;
        const isbn = formData.isbn !== 0 ? formData.isbn : props.book.isbn;

        props.onEditBook(props.book.id, name, bookCategoryId, authorId,availableCopies, isbn);
        navigate("/books")
    }

    return (
        <div className="row mt-5">
            <div className="col-md-5">
                <form onSubmit={onFormSubmit}>
                    <div className="form-group">
                        <label htmlFor="name">Book name</label>
                        <input type="text"
                               className="form-control"
                               id="name"
                               name="name"
                               required
                               placeholder={props.book.name}
                               onChange={handleChange}
                        />
                    </div>
                    <div className="form-group">
                        <label>Book Category</label>
                        <select name="bookCategoryId" className="form-control" onChange={handleChange}>
                            {props.categories.map((term) => {
                                if (props.book.categories !== undefined &&
                                    props.book.categories.id === term.id)
                                    return <option selected={props.book.categories.id}
                                                   value={term.id}>{term.name}</option>
                                else return <option value={term.id}>{term.name}</option>
                            })}

                        </select>
                    </div>
                    <div className="form-group">
                        <label>Authors</label>
                        <select name="authorId" className="form-control" onChange={handleChange}>
                            {props.authors.map((term) => {
                                if (props.book.authors !== undefined &&
                                    props.book.authors.id === term.id)
                                    return <option selected={props.book.authors.id} value={term.id}>{term.name}</option>
                                else return <option value={term.id}>{term.name}</option>
                            })}
                        </select>
                    </div>
                    <div className="form-group">
                        <label htmlFor="quantity">Available Copies</label>
                        <input type="text"
                               className="form-control"
                               id="availableCopies"
                               name="availableCopies"
                               placeholder={props.book.availableCopies}
                               required
                               onChange={handleChange}
                        />
                    </div>
                    <div className="form-group">
                        <label htmlFor="quantity">ISBN</label>
                        <input type="text"
                               className="form-control"
                               id="isbn"
                               name="isbn"
                               placeholder={props.book.isbn}
                               required
                               onChange={handleChange}
                        />
                    </div>
                    <button id="submit" type="submit" className="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>
    )

}
export default BookEdit;