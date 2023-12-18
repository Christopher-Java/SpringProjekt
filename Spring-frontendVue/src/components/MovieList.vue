<template>
  <div>
    <h2 class="h4 mb-4">Movie Genres</h2>
    <div class="row">
      <div v-for="genre in genres" :key="genre.id" class="col-md-4 mb-4">
        <div class="card">
          <!-- You can add images or icons for each genre if available -->
          <div class="card-body">
            <h5 class="card-title">{{ genre }}</h5>
            <p class="card-text">{{ genre.description }}</p>
            <button @click="fetchMoviesByGenre(genre)"> Select </button>
            
          </div>
        </div>
      </div>
    </div>
  </div>
  <div>
    <div class="row">
      <form>
        <label for="customerId">Your customer ID</label>
        <input v-model="customerid" class="form-control" id="customerId">
      </form>
      <div v-for="movie in movies" :key="movie.id" class="col-md-4 mb-4">
        <div class="card">
          <!-- You can add images or icons for each genre if available -->
          <div class="card-body">
            <h5 class="card-title">{{ movie.movieTitle }}</h5>
            <p class="card-text">{{ movie.description }}</p>


            <button @click="rentMovie(movie)"> Rent movie</button>

          </div>
        </div>
      </div>
    </div>
  </div>
</template>


<script>

export default {
  name: 'MovieList',
  data() {
    return {
      movies: [],
      customerid: null,
      genres: [],
    };
  },
  mounted() {
    // Fetch genres from the API when the component is mounted
    this.fetchMovies();
    this.fetchGenres();
  },
  methods: {
    async fetchMovies() {
      // Make an API call to get the list of movies
      const response = await fetch("http://localhost:8081/movies/get-all-movies")
      console.log(response)
      this.movies = await response.json()
    },
    async fetchMoviesByGenre(genre){
      
      console.log("localhost:8081/movies/get-movies-by-genre/"+genre)
      const response = await fetch("http://localhost:8081/movies/get-movies-by-genre/"+genre)

      
      this.movies = await response.json()
      console.log(this.movies)
    },
    async fetchGenres() {
      // Make an API call to get the list of genres
      const response = await fetch("http://localhost:8081/movies/get-genres")
      console.log(response)
      this.genres = await response.json()
    },
    async rentMovie(movie) {
      const postData = {
        customerId: this.customerid,
        movieId: movie.id,
        rentalCost: 75,
        rentalDate: currentDate
      };
      var currentDate = new Date();

      console.log(this.customerid + " want to hire " + movie.id)
      // eslint-disable-next-line
      const requestOptions = {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify(postData)
      };
      const response = await fetch("http://localhost:8082/rental/create-rental", requestOptions)
      const data = await response.json()
      this.postId = data.id

    }
  },
};
</script>

<style scoped>
/* Add your custom styles here */
</style>
