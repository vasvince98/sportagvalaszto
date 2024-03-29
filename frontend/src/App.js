import {useState, useEffect} from 'react';
import BookCreate from "./components/BookCreate";
import BookList from "./components/BookList";
import axios from "axios";


function App() {

    const [books, setBooks] = useState([]);

    const fetchBooks = async () => {
        const response = await axios.get('http://localhost:6788/cards');
        setBooks(response.data);
    }

    useEffect(() => {
        fetchBooks();
    }, []);

    const editBookById = (id, title) => {
        const updatedBooks = books.map((book) => {
            if (book.id === id) {
                return { ...book, title };
            }
            return book;
        });

        setBooks(updatedBooks);
    };

    const deleteBookById = (id) => {
        const updatedBooks = books.filter((book) => {
            return book.id !== id;
        });

        setBooks(updatedBooks);
    };

    const createBook = async (title, name) => {
        const response = await axios.post('http://localhost:6788/cards', {
            title,
            name
        });

        const voteResponse = await axios.post('https://sportagvalaszto.vasvince.com:3001/votes', {
            bookId: response.data.id,
            votes: 0
        });


        const updatedBook = [
            ...books,
            response.data
        ];
        setBooks(updatedBook);
    }

    return (
        <div className="app">
            <h1>Adj hozzá eseményt és szavazz arra, amiben szívesen részt vennél!</h1>
            <BookList books={books} onDelete={deleteBookById} onEdit={editBookById}/>
            <BookCreate onCreate={createBook}/>
        </div>
    );
}

export default App;
