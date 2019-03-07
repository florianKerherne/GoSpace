<template>
  <div class="Panier">
    <p>VOS VOYAGE(S) :
      <br>
    </p>
    <div v-for="item in posts" v-bind:key="item" class="ArticlesVoyage">
      <div>
        <p>Planete de départ : {{item.planeteDepart}}</p>
        <p>Planete de d'arrivé : {{item.planeteArrive}}</p>
        <p>Lieu de départ : {{item.lieuDepart}}</p>
        <p>Lieu de destination : {{item.lieuDestination}}</p>
        <p>Nombres de places Réservés : {{item.nbPlacesReserves}}</p>
        <p>Prix : {{item.prix}}</p>
        <br>
      </div>
    </div>
    <div id>
      <h3>Coût total du panier : {{this.prixTotal}} $</h3>
      <b-btn class="BoutonArticle" @click="PayerPanier()">Payment</b-btn>
    </div>
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
    PayerPanier() {
      this.$router.push({ path: `/payment/` });
    },
    getResultat() {
      var tailleTableau = this.posts.length;
      this.prixTotal = 0;
      var i;
      for (i = 0; i < tailleTableau; i++) {
        this.posts.pop();
      }
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
        postsTemp.push(object);
      });
      this.posts = postsTemp;
      this.prixTotal = prixToTalTemp;
    }
  },
  mounted: function() {
    AXIOS.get(`panier/` + 1)
      .then(response => {
        this.result = response.data;
        this.getResultat();
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

.BoutonArticle {
  position: center;
  text-align: center;
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
