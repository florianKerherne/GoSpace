<template>
  <div class="about">
    <b-btn @click="test()">CALL Spring Boot REST backend service</b-btn>
    <p>For a guide and recipes on how to configure / customize this project,
      <br>check out the
    </p>
    <h3>Installed CLI Plugins</h3>
  </div>
</template>


<script>
import { AXIOS } from "../components/http-common";

export default {
  name: "about",

  data() {
    return {
      posts: [],
      errors: [],
      userId: "123"
    };
  },
  methods: {
    // Fetches posts when the component is created.
    callRestService() {
      AXIOS.get(`about`)
        .then(response => {
          // JSON responses are automatically parsed.
          this.posts = response.data;
        })
        .catch(e => {
          this.errors.push(e);
        });
    },

    test() {
      //this.$router.push({ path: `/Connexion/${this.userId}` });
      this.$router.push({ path: `/Connexion/`, query: { id: this.userId } });
    }
  }
};
</script>
