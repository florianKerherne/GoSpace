<template>
  <div class="listVoyage">
    <b-form inline>
      <b-form-group id="InputPlaneteGroup" label="Planete:" label-for="InputPlanete">
        <b-form-input
          id="InputPlanete"
          type="text"
          required
          placeholder="Sélectionner une planete"
          v-model="searchPlanete"
        ></b-form-input>
      </b-form-group>
      <b-form-group id="InputLieuGroup" label="Lieu:" label-for="InputLieu">
        <b-form-input id="InputLieu" type="text" required placeholder="saisir un lieu"></b-form-input>
      </b-form-group>
      <b-button variant="primary" @click="search()">Rechercher</b-button>
    </b-form>
    <p>vos voyage :
      <br>
    </p>
    <h3>----</h3>
    <b-list-group></b-list-group>
    <!--<div>
      <b-row v-for="item in result" v-bind:key="item">
          <ArticleVoyage :idArticle=item.id></ArticleVoyage>
        </b-row>
    </div>-->
    <ul id="example-1">
      <li v-for="item in result" v-bind:key="item">
        <ArticleVoyage :idArticle=item.id></ArticleVoyage>
        <br>
      </li>
    </ul>
  </div>
</template>


<script>
import { AXIOS } from "../components/http-common";
import ArticleVoyage from "@/components/ArticleVoyage.vue";

export default {
  name: "listVoyage",
  components: {
    ArticleVoyage
  },
  data() {
    return {
      result: [],
      searchPlanete: "",
      posts: [],
      errors: []
    };
  },

  methods: {
    // Fetches posts when the component is created.
    search() {
      AXIOS.get(`voyages/` + this.searchPlanete.toLowerCase())
        .then(response => {
          // JSON responses are automatically parsed.
          this.result = response.data;
        })
        .catch(e => {
          this.errors.push(e);
        });
    }
  },
  mounted: function() {
    AXIOS.get(`voyages`)
      .then(response => {
        this.result = response.data;
      })
      .catch(e => {
        this.errors.push(e);
      });
  }
};
</script>
<style scoped>

</style>
