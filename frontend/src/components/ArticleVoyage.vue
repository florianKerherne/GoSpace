<template>
  <div class="articleVoyage">
    <b-btn @click="callRestService()">CALL Spring Boot REST backend service</b-btn>
    <p>go to the space !
      <br>Paris - Mars
    </p>
    <h3>999€99</h3>
  </div>
</template>


<script>
import { AXIOS } from "./http-common";

export default {
  name: "articleVoyage",

  data() {
    return {
      posts: [],
      errors: []
    };
  },
  methods: {
    // Fetches posts when the component is created.
    callRestService() {
      AXIOS.get(`hello`)
        .then(response => {
          // JSON responses are automatically parsed.
          this.posts = response.data;
        })
        .catch(e => {
          this.errors.push(e);
        });
    }
  }
};
</script>