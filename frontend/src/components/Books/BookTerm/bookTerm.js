import React from 'react';
import {Link} from 'react-router-dom';

const bookTerm = (props) => {
    return (
        <div className="card">
            <div className="card-body">
                <img src={`https://prodimage.images-bn.com/lf?set=key%5Bresolve.pixelRatio%5D,value%5B1%5D&set=key%5Bresolve.width%5D,value%5B300%5D&set=key%5Bresolve.height%5D,value%5B10000%5D&set=key%5Bresolve.imageFit%5D,value%5Bcontainerwidth%5D&set=key%5Bresolve.allowImageUpscaling%5D,value%5B0%5D&set=key%5Bresolve.format%5D,value%5Bwebp%5D&product=path%5B/pimages/${props.term.isbn}_p0_v2%5D&call=url%5Bfile:common/decodeProduct.chain%5D`}/>
                <h5 className="card-title">{props.term.name}</h5>
                <h6 className="card-subtitle mb-2 text-body-secondary">Author: {props.term.author.name} {props.term.author.surname}</h6>
                <p className="card-text">Available Copies: {props.term.availableCopies}</p>
                <p className="card-text">ISBN number: {props.term.isbn}</p>
                <a title={"Delete"} className={"btn btn-danger"}
                   onClick={() => props.onDelete(props.term.id)}>
                    Delete
                </a>
                <a title={"Delete"} className={"btn btn-primary"}
                   onClick={() => props.onMark(props.term.id)}>
                    Book now
                </a>
                <Link className={"btn btn-info ml-2"}
                      onClick={() => props.onEdit(props.term.id)}
                      to={`/books/edit/${props.term.id}`}>
                    Edit
                </Link>
            </div>
        </div>


    )
}

export default bookTerm;