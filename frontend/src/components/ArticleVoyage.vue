<template>
  <div class="ArticleVoyage">
    <div>
      <div id="photo"></div>
      <div id="descriptif">
        <h3>{{nom}}</h3>
        <h5>{{destination}}</h5>
        <p>{{description}}
          <br>
        </p>
      </div>
    </div>
    <div id="piedDePage">
      <h5>{{prix}}</h5>
      <b-btn>GO to the SPACE</b-btn>
    </div>
  </div>
</template>


<script>
import { AXIOS } from "./http-common";

export default {
  name: "ArticleVoyage",

  data() {
    return {
      nom : "",
      destination : "",
      description : "",
      prix : 0,
      posts: [],
      errors: []
    };
  },
  methods: {
    // Fetches posts when the component is created.
  },
  mounted:function() {
      AXIOS.get(`voyage/1`)
        .then(response => {
          // JSON responses are automatically parsed.
          this.nom = response.data.nom
          this.prix = response.data.prix
          this.description = response.data.description
          this.destination = response.data.idLieuDestination.planete + " " +response.data.idLieuDestination.nom
        })
        .catch(e => {
          this.errors.push(e);
        });
    }
};
</script>

<style scoped>
.ArticleVoyage {
  color: #321168;
  background-color: rgb(141, 26, 106);
  border-radius:2px;box-shadow:0 2px 2px 0 rgba(0,0,0,0.16),0 0 0 1px rgba(0,0,0,0.08);display:table;margin-bottom:12px;position:relative;table-layout:fixed;width:100%
}

#photo{
  display:table-cell;padding:12px;position:relative;text-align:center;vertical-align:middle;width:180px;
  color: #6e6e6e;
  background-color: rgb(71, 71, 71);
}
#descriptif {

  color: #eb0606;
  background-color: rgb(14, 168, 168);
 
  display:table-cell;padding:12px;vertical-align:middle
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