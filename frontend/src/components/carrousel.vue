<template>
  <div id="carousel">
    <b-carousel
      id="carousel1"
      style="text-shadow: 1px 1px 2px #333;"
      controls
      background="#ababab"
      :interval="3000"
      img-width="500"
      img-height="230"
      v-model="slide"
      @sliding-start="onSlideStart"
      @sliding-end="onSlideEnd"
    >
      <b-carousel-slide>
        <img
          slot="img"
          class="d-block img-fluid w-100"
          src="https://picsum.photos/500/230?image=1051"
          alt="image slot"
        >
      </b-carousel-slide>
      <b-carousel-slide>
        <img
          slot="img"
          class="d-block img-fluid w-100"
          src="https://picsum.photos/500/230?image=1043"
          alt="image slot"
        >
      </b-carousel-slide>
      <!-- Slides with image only -->
      <b-carousel-slide>
        <img
          slot="img"
          class="d-block img-fluid w-100"
          src="https://picsum.photos/500/230?image=1028"
          alt="image slot"
        >
      </b-carousel-slide>

      <!-- Slides with img slot -->
      <!-- Note the classes .d-block and .img-fluid to prevent browser default image alignment -->
      <b-carousel-slide>
        <img
          slot="img"
          class="d-block img-fluid w-100"
          src="https://picsum.photos/500/230?image=1016"
          alt="image slot"
        >
      </b-carousel-slide>

      <b-carousel-slide>
        <img
          slot="img"
          class="d-block img-fluid w-100"
          src="https://picsum.photos/500/230?image=1045"
          alt="image slot"
        >
      </b-carousel-slide>
    </b-carousel>
  </div>
</template>

<script>
export default {
  data() {
    return {
      slide: 0,
      sliding: null
    };
  },
  methods: {
    onSlideStart() {
      this.sliding = true;
    },
    onSlideEnd() {
      this.sliding = false;
    }
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}

#carousel {
  width: 60%;
  height: 50%;
  margin: auto;
}

b-carousel {
  width: 80%;
  height: 50%;
  margin: auto;
}
</style>
