import axios from 'axios'

const baseUrl = 'http://localhost:8080/api/ratings';

export class RatingApi {
    
    constructor() {}

    async getRatings() {
        console.log('getRatings()')
        const { data } = await axios.get(baseUrl);
        console.log('getRatings() data', data)
        return data;
    }

}