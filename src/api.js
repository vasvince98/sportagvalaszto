import axios from "axios";

const searchImages = async (term) => {
    const response = await axios.get("https://api.unsplash.com/search/photos", {
        headers: {
            Authorization: 'Client-ID Z9LEPRVFJgMpJfiqKZSYhTzKDNZCL75g5_yHHWepm3o'
        },
        params: {
            query: term
        }
    })


    return response.data.results;
};

export default searchImages;
