<template>
  <div class="voyage">
    <b-btn @click="callRestService()">CALL Spring Boot REST backend service</b-btn>
    <p>For a guide and recipes on how to configure / customize this project,
      <br>check out the
    </p>
    <h3>Installed CLI Plugins</h3>
  </div>
</template>


<script>
import { AXIOS } from "../components/http-common";

export default {
  name: "voyage",

  data() {
    return {
      posts: [],
      errors: []
    };
  },
  methods: {
    // Fetches posts when the component is created.
    callRestService() {
      AXIOS.get(`voyage`)
        .then(response => {
          // JSON responses are automatically parsed.
          this.posts = response.data;
        })
        .catch(e => {
          this.errors.push(e);
        });
    }
  },
  mounted:function() {
    // AXIOS.get(`voyage/1`)
    //   .then(response => {
    //     // JSON responses are automatically parsed.
    //     this.nom = response.data.nom
    //     this.prix = response.data.prix
    //     this.description = response.data.description
    //     this.destination = response.data.idLieuDestination.planete + " " +response.data.idLieuDestination.nom
    //   })
    //   .catch(e => {
    //     this.errors.push(e);
    //   });
  }
};
</script>
