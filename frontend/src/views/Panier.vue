<template>
  <div class="Panier">
    <p>vos voyage :
      <br>
    </p>
    <ul id="example-1">
      <div class="ArticleVoyage">
        <div>
          <div id="photo"></div>
          <div id="descriptif">
            <h3>{{this.prixTotal}}</h3>
            <h5></h5>
            <p>
              <br>
            </p>
          </div>
        </div>
        <div id="piedDePage">
          <h5 class="PrixArticle"></h5>
          <b-btn class="BoutonArticle" @click="accessVoyage()">GO to the SPACE</b-btn>
        </div>
      </div>
    </ul>
    <h3>Installed CLI Plugins</h3>
  </div>
</template>


<script>
import { AXIOS } from "../components/http-common";
//import ArticleVoyage from "@/components/ArticleVoyage.vue";

export default {
  name: "listVoyage",
  components: {
    //ArticleVoyage
  },
  data() {
    return {
      result: [],
      prixTotal: "",
      posts: [],
      errors: []
    };
  },

  methods: {
    accessVoyage() {},
    getResultat() {
      var tailleTableau = this.posts.length;
      this.prixTotal = 0;
      var i;
      console.log("test2");
      for (i = 0; i < tailleTableau; i++) {
        this.posts.pop();
      }
      console.log("test3");
      var prixToTalTemp = 0;
      var postsTemp = [];
      this.result.forEach(function(element) {
        var object = {
          prix: element.id_voyage.prix,
          planeteDepart: element.id_voyage.idLieuDepart.planete,
          planeteDestiantion: element.id_voyage.idLieuDestination.planete,
          lieuDepart: element.id_voyage.idLieuDepart.nom,
          lieuDestination: element.id_voyage.idLieuDestination.nom,
          promotion: element.id_voyage.promotion,
          nbPlacesReserves: element.nb_places_reserves,
          dateDebut: element.id_voyage.date_debut,
          dateFin: element.id_voyage.date_fin
        };
        prixToTalTemp += element.id_voyage.prix;
        console.log(object);
        postsTemp.push(object);
        console.log("test5");
      });
      console.log("test6");
      this.posts = this.postsTemp;
      this.prixTotal = prixToTalTemp;
      console.log(this.prixTotal);
    }
  },
  mounted: function() {
    AXIOS.get(`panier/` + 1)
      .then(response => {
        this.result = response.data;
        console.log("test");
        this.getResultat();
        console.log("test12");
        console.log(this.result.length);
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
  text-align: left;
  border-radius: 2px;
  box-shadow: 0 2px 2px 0 rgba(0, 0, 0, 0.16), 0 0 0 1px rgba(0, 0, 0, 0.08);
  display: table;
  margin-bottom: 12px;
  position: relative;
  table-layout: fixed;
  width: 100%;
}

#photo {
  display: table-cell;
  padding: 12px;
  position: relative;
  text-align: center;
  vertical-align: middle;
  width: 180px;
  color: #6e6e6e;
  background-color: rgb(71, 71, 71);
}
#descriptif {
  color: #eb0606;
  background-color: rgb(14, 168, 168);
  text-align: left;
  display: table-cell;
  padding: 12px;
  vertical-align: middle;
}
#piedDePage {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: right;
  color: #eb0606;
  background-color: rgb(0, 255, 55);
}
#BoutonArticle {
  float: right;
}
#PrixArticle {
  float: left;
}
</style>
