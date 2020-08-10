<template>
    <div>

        <h1>Add Movie</h1>


        <input class="input" type="text" placeholder="Movie Title" />

        <input class="input" type="number" placeholder="Movie Length" />

        <input class="input" type="date" placeholder="Release Date" />

        <select v-model="movie.director.id">
            <option v-for="director in directors" :value="director.id" :key="director.id">
                {{ director.firstName }} {{ director.lastName }}
            </option>
        </select>
       
        <!-- <select v-model="movie.genre.id">
            <option v-for="genre in genre" :value="director.id" :key="genre.id">
                {{ genre.firstName }} {{ genre.lastName }}
            </option>
        </select> -->


    </div>
</template>

<script>
export default {
    data: () => ({
        movie: {
            director: {}
        },
        directors: [],
        genres: []
    }),
    methods: {
        save() {
            // save movie, that movie object (data.movie) will be sent
        },
        cancel() {

        }
    },
    async mounted() {
        const { data } = await this.$http.get('http://localhost:8080/api/directors');
        console.log('getDirectors() data', data)
        this.directors = data;

        // const { data } = await this.$http.get('http://localhost:8080/api/genres');
        // console.log('getGenres() data', data)
        // this.directors = data;

    }
}
</script>