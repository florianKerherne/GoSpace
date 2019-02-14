<template>
  <div class="ArticleVoyage">
    <div>
      <div id="photo"></div>
      <div id="descriptif">
        <h3>{{DestinationPlanete}} {{DestinationNom}}</h3>
        <h5>{{DestinationDescription}}</h5>
        <h6>Lieu de départ : {{DepartPlanete}} {{DepartNom}}</h6>
        <h6>Date de départ le {{DateDepart}} - Date d'arrivé le {{DateArrive}}</h6>
        <p>
          {{description}}
          <br>
        </p>
      </div>
    </div>
    <div id="piedDePage">
      <h6 class="PlaceRestante">{{nbPlace}} places restantes</h6>
      <h6 v-if="prixNonPromo>0" class="PrixNonPromo">{{prixNonPromo}} €</h6>
      <h5 class="PrixArticle">{{prixFinal}} €</h5>
      <b-btn class="BoutonAjoutPanier" @click="AjouterAuPanier(this.id)">Ajouter au panier</b-btn>
      <b-btn class="BoutonArticle" @click="reserver(this.id)">Réserver</b-btn>
    </div>
  </div>
</template>


<script>
import { AXIOS } from "../components/http-common";

export default {
  name: "voyage",

  data() {
    return {
      DestinationPlanete: "",
      DestinationNom: "",
      DestinationDescription: "",
      DepartPlanete: "",
      DepartNom: "",
      description: "",
      prixFinal: "",
      prixNonPromo: 0,
      nbPlace: 0,
      id: "",
      DateDepart: "",
      DateArrive: "",
      posts: [],
      errors: []
    };
  },
  methods: {
    chargeVoyage(idVoyage) {
      AXIOS.get(`voyage/` + idVoyage)
        .then(response => {
          // JSON responses are automatically parsed.
          this.DestinationPlanete = response.data.idLieuDestination.planete;
          this.DestinationNom = response.data.idLieuDestination.nom;
          this.DestinationDescription =
            response.data.idLieuDestination.description;
          this.DepartPlanete = response.data.idLieuDepart.planete;
          this.DepartNom = response.data.idLieuDepart.nom;
          this.description = response.data.description;
          if (response.data.promotion > 0) {
            this.prixNonPromo = response.data.prix;
            this.prixFinal =
              response.data.prix -
              (response.data.prix * response.data.promotion) / 100;
          } else {
            this.prixFinal = response.data.prix;
          }
          this.nbPlace = response.data.nb_places_restantes;
          this.id = response.data.id;
          var varDateDepart = new Date(response.data.date_debut);
          var varDateArrive = new Date(response.data.date_fin);
          this.DateDepart =
            varDateDepart.getDay() +
            "/" +
            varDateDepart.getMonth() +
            "/" +
            varDateDepart.getFullYear();
          this.DateArrive =
            varDateArrive.getDay() +
            "/" +
            varDateArrive.getMonth() +
            "/" +
            varDateArrive.getFullYear();
        })
        .catch(e => {
          this.errors.push(e);
        });
    },
    AjouterAuPanier(id) {
      AXIOS.post("/panier", params)
        .then(response => {
          console.log(response.data);
        })
        .catch(e => {
          this.errors.push(e);
        });
    }
  },
  mounted: function() {
    console.log(this.$route.query.id);
    this.chargeVoyage(this.$route.query.id);
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
