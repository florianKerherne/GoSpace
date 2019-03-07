<template>
  <div class="Acceuil">
    <p>Bienvenue sur le premier site de voyage dans l'espace
      <br>
    </p>
    <div>
      <carrousel></carrousel>
    </div>
  </div>
</template>

<script>
import { AXIOS } from "../components/http-common";
import carrousel from "@/components/carrousel.vue";

export default {
  name: "Acceuil",
  components: {
    carrousel
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
      AXIOS.get(`hello`)
        .then(response => {
          // JSON responses are automatically parsed.
          this.posts = response.data;
        })
        .catch(e => {
          this.errors.push(e);
        });
    }
  }
};
</script>