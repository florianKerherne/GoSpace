<template>
  <div>
        <b-card no-body class="overflow-hidden">
          <b-row no-gutters>
            <b-col md="3">
               <b-card-img :id="['PhotoLieu'+idVoyage]" src class="rounded-0"/>
            </b-col>
            <b-col md="9">
              <b-card-body :title="[DestinationPlanete+', '+DestinationNom]">
                
                <b-card-text>
                  {{description}}
                </b-card-text>
              </b-card-body>
              <b-row no-gutters>
                <b-col md="8">
                </b-col>
                <b-col md="2">
                  <h4>Prix <b-badge>{{prixFinal}} €</b-badge></h4>
                </b-col>
                <b-col md="2">
                <b-button @click="accessVoyage()" variant="primary">GO to the SPACE</b-button>
                </b-col>
              </b-row>
            </b-col>
          </b-row>
          
        </b-card>
  </div>
  
</template>


<script>
import { AXIOS } from "./http-common";

export default {
  name: "ArticleVoyage",
  props: ['idArticle'],
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
      idVoyage: "",
      idLieu: "",
      result:"",
      posts: [],
      errors: []
    };
  },
  methods: {
    // Fetches posts when the component is created.
    ajouterImage() {
      AXIOS.get(`Photo/`+this.idLieu)
        .then(response => {
          var YourByte = response.data.data;
          document.getElementById("PhotoLieu"+this.idVoyage).src =
            "data:image/png;base64," + YourByte;
        })
        .catch(e => {
          this.errors.push(e);
        });
        this.indiceImage++;
    },
    accessVoyage() {
      this.$router.push({ path: `/voyage/`, query: { id: this.idVoyage } });
    }
  },
  mounted:function() {
    AXIOS.get(`voyage/`+this.idArticle)
      .then(response => {

          this.DestinationPlanete = response.data.idLieuDestination.planete;
          this.DestinationNom = response.data.idLieuDestination.nom;

          this.description = response.data.description;
          if (response.data.promotion > 0) {
            this.prixFinal =
              response.data.prix -
              (response.data.prix * response.data.promotion) / 100;
          } else {
            this.prixFinal = response.data.prix;
          }
          this.idVoyage = response.data.id;
          this.idLieu = response.data.idLieuDestination.id;

        //-------------
        this.result = response.data;
        this.ajouterImage();
      })
      .catch(e => {
        this.errors.push(e);
      });
  }
};
</script>

<style scoped>

</style>