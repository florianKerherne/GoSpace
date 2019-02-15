<template>
  <div class="ArticleVoyage">
    <div class="ArticleVoyage">
          <div>
            <div class="photo">
              <img :id="['PhotoLieu'+idVoyage]" height="174" width="250" src/>
            </div>
            <div class="descriptif">
              <!--<h3>{{result.nom}}</h3>-->
              <h5>{{DestinationPlanete}} {{DestinationNom}}</h5>
              <p>
                {{description}}
                <br>
              </p>
            </div>
          </div>
          <div class="piedDePage">
            <h5 class="PrixArticle">{{prixFinal}} €</h5>
            <b-btn class="BoutonArticle" @click="accessVoyage()">GO to the SPACE</b-btn>
          </div>
        </div>
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

.photo {
  display: table-cell;
  padding: 12px;
  position: relative;
  text-align: center;
  vertical-align: middle;
  width: 180px;
  color: #6e6e6e;
  background-color: rgb(71, 71, 71);
}
.descriptif {
  color: #eb0606;
  background-color: rgb(14, 168, 168);
  text-align: left;
  display: table-cell;
  padding: 12px;
  vertical-align: middle;
}
.piedDePage {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: right;
  color: #eb0606;
  background-color: rgb(0, 255, 55);
}

</style>