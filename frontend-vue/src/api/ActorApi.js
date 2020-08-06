import axios from 'axios'

const baseUrl = 'http://localhost:8080/api/actors';

export class ActorApi {
    
    constructor() {}

    async getActors() {
        console.log('getActors()')
        const { data } = await axios.get(baseUrl);
        console.log('getActors() data', data)
        return data;
    }

    async addActor(actor) {
        const response = await this.$http.post('http://localhost:8080/api/actors/', actor)
        console.log(response);
        return response;
    }

    async deleteActor(actorId) {
        const response = await axios.delete(baseUrl + '/' + actorId)
        console.log('response', response);
        return response;
    }

}