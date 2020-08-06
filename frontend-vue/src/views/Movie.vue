<template>
    <div v-if="movie">

        <span>{{ movie.movieTitle }}</span>

        <ul>
            <li>{{ movie.rating.rating }}</li>
            <li>{{ movie.movieLength }}</li>
            <li>{{ movie.genre.genre }}</li>
            <li>{{ movie.releaseDate }}</li>
        </ul>

        <iframe width="560" height="315" :src="movie.trailerUrl" frameborder="0"
            allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
            allowfullscreen></iframe>

    </div>
</template>

<script>
import {MovieApi} from '../api/MovieApi';
const movieApi = new MovieApi();

export default {
    data: () => ({
        movie: null
    }),
    async mounted() {
        let movie = await movieApi.getMovie(this.$route.params.id);
        if (movie != null) {
            this.movie = movie;
            this.year = this.moment(this.movie.releaseDate).format('YYYY');
            this.releaseDate = this.moment(this.movie.releaseDate).format('DD MMMM YYYY');
        }
    }
}
</script>