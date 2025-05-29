<template>
  <div>
    <h2>Список групп</h2>
    <table>
      <thead>
        <tr>
          <th>Группа</th>
          <th>Кол-во студентов</th>
          <th>Список студентов</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="group in groups" :key="group.id">
          <td>{{ group.groupName }}</td>
          <td>{{ group.studentCount }}</td>
          <td>
            <router-link
              :to="`/groups/${group.groupId}/students`"
              class="button-link"
            >
              Перейти
            </router-link>
          </td>
        </tr>
      </tbody>
    </table>

    <h3>Добавить новую группу</h3>
    <input v-model="newGroupName" placeholder="Введите название группы" />
    <button @click="addGroup">Добавить</button>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  data() {
    return {
      groups: [],
      newGroupName: ''
    }
  },
  mounted() {
    this.loadGroups()
  },
  methods: {
    loadGroups() {
      axios.get('http://localhost:8080/api/v1/group/all')
        .then(res => this.groups = res.data)
        .catch(err => console.error(err))
    },
    addGroup() {
      axios.post('http://localhost:8080/api/v1/group', {
        groupName: this.newGroupName
      }).then(() => {
        this.newGroupName = ''
        this.loadGroups()
      }).catch(err => console.error(err))
    }
  }
}
</script>
