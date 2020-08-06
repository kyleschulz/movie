import axios from 'axios'

const baseUrl = 'http://localhost:8080/api/genres';

export class GenreApi {
    
    constructor() {}

    async getGenres() {
        console.log('getGenres()')
        const { data } = await axios.get(baseUrl);
        console.log('getGenres() data', data)
        return data;
    }

}