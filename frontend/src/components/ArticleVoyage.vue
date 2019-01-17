<template>
  <div class="ArticleVoyage">
    <div>
      <div id="photo"></div>
      <div id="descriptif">
        <h3>Titre</h3>
        <h5>Zone de départ</h5>
        <p>Descriptif
          <br>Paris - Mars
        </p>
      </div>
    </div>
    <div id="piedDePage">
      <h5>999€99</h5>
      <b-btn @click="callRestService()">GO to the SPACE</b-btn>
    </div>
  </div>
</template>


<script>
import { AXIOS } from "./http-common";

export default {
  name: "ArticleVoyage",

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

<style scoped>
.ArticleVoyage {
  padding: 30px;
  color: #321168;
  background-color: rgb(141, 26, 106);
  margin-left:110px;
}
#photo {
  padding: 30px;
  color: #6e6e6e;
  background-color: rgb(71, 71, 71);
  margin-left:110px;
  float: left;
}
#descriptif {
  padding: 30px;
  color: #eb0606;
  background-color: rgb(14, 168, 168);
  float: center;
}
#piedDePage {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  /*text-align: center;*/
  color: #eb0606;
  background-color: rgb(0, 255, 55);
}
</style>