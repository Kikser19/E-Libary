import React from "react";
import {useNavigate} from 'react-router-dom';

const AuthorAdd = (props) => {
    const navigate = useNavigate();
    const [formData, updateFormData] = React.useState({
        name: "",
        surname: "",
        country: 1,
        biography: "",
        dateOfBirth: ""
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
        const surname = formData.surname;
        const country = formData.country;
        const biography = formData.biography;
        const dateOfBirth = formData.dateOfBirth;

        props.onAddAuthor(name, surname, country,biography, dateOfBirth);
        navigate("/authors")
    }

    return (
        <div className="row mt-5">
            <div className="col-md-5">
                <form onSubmit={onFormSubmit}>
                    <div className="form-group">
                        <label htmlFor="name">Author name</label>
                        <input type="text"
                               className="form-control"
                               id="name"
                               name="name"
                               required
                               placeholder="Enter author name"
                               onChange={handleChange}
                        />
                    </div>
                    <div className="form-group">
                        <label htmlFor="name">Author surname</label>
                        <input type="text"
                               className="form-control"
                               id="surname"
                               name="surname"
                               required
                               placeholder="Enter author surname"
                               onChange={handleChange}
                        />
                    </div>
                    <div className="form-group">
                        <label>Country</label>
                        <select name="countryId" className="form-control" onChange={handleChange}>
                            {props.countries.map((term) =>
                                <option value={term.id}>{term.name}</option>
                            )}
                        </select>
                    </div>
                    <div className="form-group">
                        <label htmlFor="quantity">Biography</label>
                        <textarea
                            className="form-control"
                            id="biography"
                            name="biography"
                            placeholder="Biography"
                            required
                            onChange={handleChange}></textarea>
                    </div>
                    <div className="form-group">
                        <label htmlFor="dateOfBirth">Date of Birth</label>
                        <input type="date"
                               className="form-control"
                               id="dateOfBirth"
                               name="dateOfBirth"
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
export default AuthorAdd;