<template>
    <div v-if="!loading">
        <h1 class="title">Add Movie</h1>

            <div class="field">
                <label class="label">Title</label>
                <div class="control">
                    <input class="input" type="text" v-model="movie.movieTitle" placeholder="Title" />
                </div>
            </div>

            <div class="field">
                <label class="label">Movie Length</label>
                <div class="control">
                    <input class="input"
                        type="number"
                        v-model="movie.movieLength"
                        placeholder="Movie Length" />
                </div>
            </div>

            <div class="field">
                <label class="label">Release Date</label>
                <div class="control">
                    <input class="input" type="date" v-model="movie.releaseDate" placeholder="Release Date" />
                </div>
            </div>

            <div class="field">
                <label class="label">Genre</label>
                <div class="select">
                    <select v-model="movie.genre.id">
                        <option v-for="genre in genres" :value="genre.id" :key="genre.id">
                            {{ genre.genre }}
                        </option>
                    </select>
                </div>
            </div>

            <div class="field">
                <label class="label">Rating</label>
                <div class="select">
                    <select v-model="movie.rating.id">
                        <option v-for="rating in ratings" :value="rating.id" :key="rating.id">
                            {{ rating.rating }}
                        </option>
                    </select>
                </div>
            </div>

            <div class="field">
                <label class="label">Director</label>
                <div class="select">
                    <select v-model="movie.director.id">
                        <option v-for="director in directors" :value="director.id" :key="director.id">
                            {{ director.firstName }} {{ director.lastName }}
                        </option>
                    </select>
                </div>
            </div>

            <div class="control" v-for="actor in actors" :key="actor.id">
                <label :for="actor.id" class="checkbox">
                    <input type="checkbox" :id="actor.id" :value="actor" v-model="movie.actors" />
                    {{ actor.firstName }} {{ actor.lastName }}
                </label>
            </div>

            <div class="field is-grouped">
                <p class="control">
                    <button @click="cancel" class="button">Cancel</button>
                </p>
                <p class="control">
                    <button @click="save" class="button is-primary">Save</button>
                </p>
            </div>

    </div>
</template>

<script>
import {ActorApi} from '../api/ActorApi';
import {DirectorApi} from '../api/DirectorApi';
import {GenreApi} from '../api/GenreApi';
import {MovieApi} from '../api/MovieApi';
import {RatingApi} from '../api/RatingApi';

const actorApi = new ActorApi();
const directorApi = new DirectorApi();
const genreApi = new GenreApi();
const movieApi = new MovieApi();
const ratingApi = new RatingApi();

export default {
    name: 'AddMovie',
    data: () => ({
        loading: true,
        movie: {
            movieTitle: null,
            movieLength: null,
            releaseDate: null,
            trailerUrl: null,
            director: {},
            actors: [],
            genre: {},
            rating: {}
        },
        directors: [],
        actors: [],
        genres: [],
        ratings: [],
    }),
    methods: {
        cancel() {
            this.$router.push({path: '/movies'});
        },
        async save() {
            try {
                const response = await movieApi.createMovie(this.movie);
                if (response) {
                   this.$router.push({ path: '/movies'});
                } else {
                    console.log('Movie not saved');
                }
            } catch (err) {
                console.error(err);
            }
        },
        async initializeData() {
            this.actors = await actorApi.getActors();
            this.directors = await directorApi.getDirectors();
            this.genres = await genreApi.getGenres();
            this.ratings = await ratingApi.getRatings();
        }
    },
    async mounted() {
        console.log('actors mounted begin');
        await this.initializeData();
        this.loading = false;
    },
}
</script>

<style scoped>
</style>