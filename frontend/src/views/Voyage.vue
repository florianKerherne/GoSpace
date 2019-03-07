<template>
  <div class="ArticleVoyage">
    <!--<div>
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
      <b-btn class="BoutonAjoutPanier" @click="AjouterAuPanier()">Ajouter au panier</b-btn>
      <b-btn class="BoutonArticle" @click="reserver(this.id)">Réserver</b-btn>
    </div>-->
      <b-card no-body class="overflow-hidden">
      <b-row no-gutters>
        <b-col md="3">
            <b-card-img :id="['PhotoLieu'+id]" src class="rounded-0"/>
        </b-col>
        <b-col md="9">
          <b-card-body :title="[DestinationPlanete+', '+DestinationNom]">
            
            <!--<b-card-text>-->
              <h5>{{DestinationDescription}}</h5>
              <h6>Lieu de départ : {{DepartPlanete}} {{DepartNom}}</h6>
              <h6>Date de départ le {{DateDepart}} - Date d'arrivé le {{DateArrive}}</h6>
            <!--</b-card-text>-->
          </b-card-body>
          <b-row no-gutters>
            <b-col md="3">
              <h6><b-badge>{{nbPlace}}</b-badge> places restantes</h6>
            </b-col>
            <b-col md="4">
              <h4 style="display: inline-block;">Prix <h6 style="display: inline-block;"><s v-if="prixNonPromo">{{prixNonPromo}} €</s></h6><b-badge>{{prixFinal}} €</b-badge></h4>
            </b-col>
            <b-col md="2">
              <b-btn class="BoutonAjoutPanier" @click="AjouterAuPanier()">Ajouter au panier</b-btn>
            </b-col>
            <b-col md="2">
              <b-btn class="BoutonArticle" @click="accessPayement()">Réserver</b-btn>
            </b-col>
          </b-row>
        </b-col>
      </b-row>
      
    </b-card>
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
      idLieu: "",
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
          this.idLieu = response.data.idLieuDestination.id;
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
          this.ajouterImage();
        })
        .catch(e => {
          this.errors.push(e);
        });
    },
    AjouterAuPanier() {
      var params = {
        idVoyage: this.$route.query.id,
        idUtilisateur: 1,
        nbPlacesReserves: 1
      };
      AXIOS.post("/panier", params)
        .then(response => {
          console.log(response.data);
        })
        .catch(e => {
          this.errors.push(e);
        });
    },
    ajouterImage() {
      AXIOS.get(`Photo/`+this.idLieu)
        .then(response => {
          var YourByte = response.data.data;
          document.getElementById("PhotoLieu"+this.id).src =
            "data:image/png;base64," + YourByte;
        })
        .catch(e => {
          this.errors.push(e);
        });
        this.indiceImage++;
    },
    accessPayement() {
      this.$router.push({ path: `/payment/`, query: { id: this.id } });
    }
  },
  mounted: function() {
    this.chargeVoyage(this.$route.query.id);
  }
};
</script>

<style scoped>

</style>
