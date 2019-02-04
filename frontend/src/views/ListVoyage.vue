<template>
  <div class="listVoyage">
    <b-form inline>
      <b-form-group id="InputPlaneteGroup"
                    label="Planete:"
                    label-for="InputPlanete">
        <b-form-input id="InputPlanete"
                      type="text"
                      required
                      placeholder="Sélectionner une planete">
        </b-form-input>
      </b-form-group>
      <b-form-group id="InputLieuGroup"
                    label="Lieu:"
                    label-for="InputLieu">
        <b-form-input id="InputLieu"
                      type="text"
                      required
                      placeholder="saisir un lieu">
        </b-form-input>
      </b-form-group>
      <b-button variant="primary" @click="callRestService()">Rechercher</b-button>
    </b-form>
    <p>vos voyage :
      <br>
    </p>
    <b-list-group>
      <ArticleVoyage/>
    </b-list-group>
    
    <h3>Installed CLI Plugins</h3>
  </div>
</template>


<script>
import { AXIOS } from "../components/http-common";
import ArticleVoyage from '@/components/ArticleVoyage.vue';
//import HelloWorld from '@/components/HelloWorld.vue';
export default {
  name: "listVoyage",
  components: {
    ArticleVoyage
  },
  data() {
    return {
      posts: [],
      errors: []
    };
  },
  
  methods: {
    // Fetches posts when the component is created.
    callRestService() {
      AXIOS.get(`voyage/1`)
        .then(response => {
          // JSON responses are automatically parsed.
          this.posts = response.data;
          this.nom = this.posts.nom
        })
        .catch(e => {
          this.errors.push(e);
        });
    }
  }
};
</script>
