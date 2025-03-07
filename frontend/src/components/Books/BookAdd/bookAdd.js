import React from "react";
import {useNavigate} from 'react-router-dom';

const BookAdd = (props) => {

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
        const name = formData.name;
        const bookCategoryId = formData.bookCategoryId;
        const authorId = formData.authorId;
        const availableCopies = formData.availableCopies;
        const isbn = formData.isbn;

        props.onAddBook(name, bookCategoryId, authorId,availableCopies, isbn);
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
                               placeholder="Enter book name"
                               onChange={handleChange}
                        />
                    </div>
                    <div className="form-group">
                        <label>Book Category</label>
                        <select name="bookCategoryId" className="form-control" onChange={handleChange}>
                            {props.categories.map((term) =>
                                <option value={term.id}>{term.name}</option>
                            )}
                        </select>
                    </div>
                    <div className="form-group">
                        <label>Authors</label>
                        <select name="authorId" className="form-control" onChange={handleChange}>
                            {props.authors.map((term) =>
                                <option value={term.id}>{term.name} {term.surname}</option>
                            )}
                        </select>
                    </div>
                    <div className="form-group">
                        <label htmlFor="quantity">Available Copies</label>
                        <input type="text"
                               className="form-control"
                               id="availableCopies"
                               name="availableCopies"
                               placeholder="Available Copies"
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
                               placeholder="ISBN"
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

export default BookAdd;