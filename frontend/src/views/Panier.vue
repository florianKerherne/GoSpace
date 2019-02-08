<template>
  <div class="Panier">
    <b-form inline>
      <b-form-group id="InputPlaneteGroup"
                    label="Planete:"
                    label-for="InputPlanete">
        <b-form-input id="InputPlanete"
                      type="text"
                      required
                      placeholder="Sélectionner une planete"
                      v-model="searchPlanete">
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
      <b-button variant="primary" @click="search()">Rechercher</b-button>
    </b-form>
    <p>vos voyage :
      <br>
    </p>
    <b-list-group>
    </b-list-group>
    <ul id="example-1">
      <li v-for="item in result">
        <div class="ArticleVoyage">
          <div>
            <div id="photo"></div>
            <div id="descriptif">
              <h3>{{item.nom}}</h3>
              <h5>{{item.idLieuDestination.planete}} {{item.idLieuDestination.nom}}</h5>
              <p>{{item.description}}
                <br>
              </p>
            </div>
          </div>
          <div id="piedDePage">
            <h5 class="PrixArticle">{{item.prix}} €</h5>
            <b-btn class="BoutonArticle" @click="accessVoyage(item.id)">GO to the SPACE</b-btn>
          </div>
        </div>
      </li>
    </ul>
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
      result: [],
      searchPlanete: "",
      posts: [],
      errors: []
    };
  },
  
  methods: {
    accessVoyage(idVoyage) {
      // console.log(idVoyage);
      // this.router.navigate(['/voyage/:id',{id:idVoyage}]);
      this.$router.push({ path: `/voyage/`, query: { id: idVoyage } });
      //jQuery.param.querystring(window.location.href, 'id='+idVoyage);
    }
  },
  mounted:function() {
    AXIOS.get(`panier/`+1)
      .then(response => {
        this.result=response.data
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
  text-align: left;
  display:table-cell;padding:12px;vertical-align:middle
}
#piedDePage {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: right;
  color: #eb0606;
  background-color: rgb(0, 255, 55);
}
#BoutonArticle {
  float: right;
}
#PrixArticle{
  float: left;
}
</style>
