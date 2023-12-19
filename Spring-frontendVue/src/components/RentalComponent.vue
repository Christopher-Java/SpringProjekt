<template>
  <div>
    <h2>All rentals</h2>
    <button @click="showAllRentals">Show All Rentals</button>
    <ul>
      <li v-for="rental in rentals" :key="rental.id">
        {{ getMovieTitle(rental.id) }} - {{ rental.customerId }}
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  data() {
    return {
      rentals: [],
    };
  },
  mounted() {
    // this.fetchAllRentals(); // Commented out to fetch rentals on button click otherwise list of rentals would be visible all the time
  },
  methods: {
    async showAllRentals() {
      await this.fetchAllRentals();
    },
    async fetchAllRentals() {
      try {
        const response = await fetch("http://localhost:8082/rental/getAllRentals");
        if (response.ok) {
          this.rentals = await response.json();
        } else {
          console.error("Failed to fetch rentals:", response.statusText);
        }
      } catch (error) {
        console.error("Error fetching rentals:", error);
      }
    },

    async getMovieTitle(id) {
      const response = await fetch("http://localhost:8081/movies/get-movie-by-id/" + id);
      if (response.ok) {
       var movie = await response.json();
        var movieTitle =await movie.movieTitle;
        return movieTitle
      }
    }
  },
};
</script>

<style scoped>
/* Add your custom styles here if needed */
</style>