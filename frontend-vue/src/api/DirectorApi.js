import axios from 'axios'

const baseUrl = 'http://localhost:8080/api/directors';

export class DirectorApi {
    
    constructor() {}

    async getDirectors() {
        console.log('getDirectors()')
        const { data } = await axios.get(baseUrl);
        console.log('getDirectors() data', data)
        return data;
    }

}