<template>
  <div class="Acceuil">
    <div>
      <h1>GO SPACE</h1>
      <p>
        Bienvenue sur le premier site de voyage dans l'espace.
        Notre Compagnie assure les trajets grâce à un service de cryogénisation dernier cri 100% fiable
        <br>qui permet un voyage en toute sécurité
      </p>
      <carrousel></carrousel>
    </div>
  </div>
</template>

<script>
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
  }
};
</script>