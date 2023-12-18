<template>
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

            
            <button @click="rentMovie(movie)"> Rent movie </button>

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
      customerid: null
    };
  },
  mounted() {
    // Fetch genres from the API when the component is mounted
    this.fetchMovies();
  },
  methods: {
    async fetchMovies() {
      // Make an API call to get the list of genres
      const response = await fetch("http://localhost:8081/movies/get-all-movies")
      console.log(response)
      this.movies = await response.json()
    },
    async rentMovie(movie) {
      
      console.log(this.customerid + " want to hire " + movie.id)
      // eslint-disable-next-line
      const requestOptions = {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: {"movieId":movie.id, "customerId":this.customerid, "rentCost":75}
      };
      const response = await fetch("http://localhost:8082/create-rental")
      const data = await response.json()
      this.postId = data.id
      
    }
  },
};
</script>

<style scoped>
/* Add your custom styles here */
</style>
