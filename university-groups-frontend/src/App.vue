<script setup>
</script>

<template>
  <div id="app">
    <h1>Управление студентами</h1>
    <router-view />
  </div>
</template>

<style>
#app {
  padding: 20px;
}

table {
  width: 100%;
  border-collapse: collapse; 
  margin-top: 20px;
}

th, td {
  border: 1px solid #ccc; 
  padding: 8px 12px;
  text-align: left;
}

th {
  background-color: #f2f2f2;
  font-weight: bold;
}

input {
  padding: 8px 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  font-size: 14px;
  margin-right: 8px;
  outline: none;
}

input:focus {
  border-color: #66afe9;
  box-shadow: 0 0 4px rgba(102, 175, 233, 0.6);
}

button {
  padding: 8px 16px;
  background-color: #4CAF50;
  color: white;
  border: none;
  border-radius: 4px;
  font-size: 14px;
  cursor: pointer;
  transition: background-color 0.2s ease;
}

button:hover {
  background-color: #45a049;
}

button:disabled {
  background-color: #cccccc;
  cursor: not-allowed;
}

.button-link {
  display: inline-block;
  padding: 8px 16px;
  background-color: #45a049;
  color: white;
  border-radius: 4px;
  text-decoration: none; 
  cursor: pointer;
  font-size: 14px;
  transition: background-color 0.2s ease;
  border: none; 
  text-align: center;
}

.button-link:hover {
  background-color: #337536;
}

</style>
