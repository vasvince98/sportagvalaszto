import {useEffect, useState} from "react";
import BookEdit from "./BookEdit";
import axios from "axios";
import searchImages from "../api";

function BookShow({book, onDelete, onEdit}) {

    const [votes, setVotes] = useState(0);

    const [showEdit, setShowEdit] = useState(false);

    const [imageSrc, setImageSrc] = useState('');

    const fetchVotes = async () => {
        const response = await axios.get(`http://localhost:3001/votes/${book.id}`);
        console.log(response.data);
        setVotes(response.data.votes);
    }

    useEffect(() => {
        async function fetchImage() {
            const url = await searchImages(book.title);
            console.log(url[0].urls.small);
            setImageSrc(url[0].urls.small);
        }
        console.log("Szia");

        fetchImage();
        fetchVotes();
    }, []);

    const updateVote = async (bookId, votes) => {
        const response = await axios.put(`http://localhost:3001/votes/${bookId}`, {
            bookId,
            votes
        });
        console.log(response.data);
    }

    const handleDeleteClick = () => {
        onDelete(book.id);
    };

    const handleEditClick = () => {
        setShowEdit(!showEdit);
    };

    const handleUpVote = () => {
        let newVote = votes + 1;
        updateVote(book.id, newVote);
        setVotes(newVote);

    }

    const handleDownVote = () => {
        if (votes === 0) {
            return;
        }
        let newVote = votes - 1;
        updateVote(book.id, newVote);
        setVotes(newVote);
    }

    const handleSubmit = (id, newTitle) => {
        setShowEdit(false);
        onEdit(id, newTitle);
    };

    let content = <h3>{book.title}</h3>;
    if (showEdit) {
        content = <BookEdit onSubmit={handleSubmit} book={book} />;
    }

    return (
        <div className="book-show">
            <img src={imageSrc} />

            <div>
                {content}
            </div>
            <h1>{votes}</h1>
            <button onClick={handleUpVote}>
                ⬆️
            </button>
            <button onClick={handleDownVote}>
                ⬇️
            </button>
            <div className="actions">

                {/*<button disabled className="edit" onClick={handleEditClick}>*/}
                {/*    Edit*/}
                {/*</button>*/}
                {/*<button disabled className="delete" onClick={handleDeleteClick}>*/}
                {/*    Delete*/}
                {/*</button>*/}
            </div>
        </div>
    )
}

export default BookShow;
