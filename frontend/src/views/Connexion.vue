<template>


  <div class="connexion">
    <div id="app">
      <b-form>
        <b-form-group id="exampleInputGroup1"
                      label="Email adresse:"
                      label-for="exampleInput1">
          <b-form-input id="exampleInput1"
                        type="email"
                        v-model="form.email"
                        required
                        placeholder="Enter email">
          </b-form-input>
        </b-form-group>
        <b-form-group id="exampleInputGroup2"
                      label="Password:"
                      label-for="exampleInput2">
          <b-form-input id="exampleInput2"
                        type="password"
                        v-model="form.name"
                        required
                        placeholder="password">
          </b-form-input>
        </b-form-group>
        <b-form-checkbox class="mb-2 mr-sm-2 mb-sm-0">Remember me</b-form-checkbox>
        <b-button variant="primary" @click="callConnexion()">Connexion</b-button>
      </b-form>
    </div>
  </div>
</template>


<script>
import { AXIOS } from "../components/http-common";

export default {
  name: "connexion",

  data() {
    return {
      posts: [],
      errors: [],
      form: {
        email: '',
        password: ''
      },
      show: true
    };
  },
  methods: {
    // Fetches posts when the component is created.
    callConnexion() {
      AXIOS.get(`connexion`)
        .then(response => {
          // JSON responses are automatically parsed.
          this.posts = response.result;
        })
        .catch(e => {
          this.errors.push(e);
        });
    },
    onSubmit (evt) {
      evt.preventDefault();
      alert(JSON.stringify(this.form));
    },
    onReset (evt) {
      evt.preventDefault();
      /* Reset our form values */
      this.form.email = '';
      this.form.password = '';
      this.show = false;
      this.$nextTick(() => { this.show = true });
    }
  }
};
</script>
<style scoped>
#co {
  padding: 30px;
  color: #eb0606;
}
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #eb0606;
}
</style>