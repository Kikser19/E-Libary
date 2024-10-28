import React from "react";


const search = (props) => {
    return (
        <div>
            <input
                type="text"
                value={this.state.searchQuery}
                onChange={(e) => this.setState({searchQuery: e.target.value})}
                placeholder="Enter book title..."
            />
            <button onClick={this.handleSearch}>Search</button>
            {this.state.error && <p>{this.state.error}</p>}
            <ul>
                {this.state.searchResults.map((book) => (
                    <li key={book.id}>{book.title} by {book.author}</li>
                ))}
            </ul>
        </div>
    )
}
export default search;