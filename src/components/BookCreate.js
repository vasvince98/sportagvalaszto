import { useState } from 'react';

function BookCreate( {onCreate} ) {

    const [title, setTitle] = useState('');
    const [user, setUser] = useState('');

    const handleTitleChange = (event) => {
        setTitle(event.target.value);
    }

    const handleUserChange = (event) => {
        setUser(event.target.value);
    }

    const handleSubmit = (event) => {
        event.preventDefault();
        onCreate(title, user);
        setTitle('');
    }

    return (
        <div className="book-create">
            <form onSubmit={handleSubmit}>
                <label>Neved</label>
                <input className="input" value={user} onChange={handleUserChange}/>
                <label>Sportág</label>
                <input className="input" value={title} onChange={handleTitleChange}/>
                <button className="button">Hozzáajhd!</button>
            </form>
        </div>
    );
}

export default BookCreate;
