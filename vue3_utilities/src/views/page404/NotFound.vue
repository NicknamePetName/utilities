<template>
  <div class="not-found">
    <h1>404 - Page Not Found</h1>
    <p>The page you are looking for does not exist.</p>
    <router-link to="/">Go to Home</router-link>
  </div>
</template>
  
  <style>
.not-found {
  text-align: center;
  margin-top: 20vh;
}

h1 {
  font-size: 3rem;
  color: red;
}

p {
  font-size: 1.5rem;
  margin: 2rem 0;
}

router-link {
  font-size: 1.2rem;
  color: blue;
}
</style>
  