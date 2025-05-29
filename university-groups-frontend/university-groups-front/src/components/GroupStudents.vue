<template>
  <div>
    <h2>Студенты группы</h2>
    <table>
      <thead>
        <tr>
          <th>Дата принятия</th>
          <th>ФИО</th>
          <th>Действие</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="student in students" :key="student.id">
          <td>{{ formatDate(student.createdAt) }}</td>
          <td>{{ student.fio }}</td>
          <td><button @click="removeStudent(student.id)">Удалить</button></td>
        </tr>
      </tbody>
    </table>

    <h3>Добавить студента</h3>
    <input v-model="newStudentFio" placeholder="ФИО студента" />
    <button @click="addStudent">Добавить</button>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  props: ['groupId'],
  data() {
    return {
      students: [],
      newStudentFio: ''
    }
  },
  mounted() {
    this.loadStudents()
  },
  methods: {
    loadStudents() {
      axios.get(`http://localhost:8080/api/v1/group/${this.groupId}/students`)
        .then(res => this.students = res.data)
        .catch(err => console.error(err))
    },
    addStudent() {
      axios.post(`http://localhost:8080/api/v1/group/${this.groupId}/students`, {
        fio: this.newStudentFio
      }).then(() => {
        this.newStudentFio = ''
        this.loadStudents()
      }).catch(err => console.error(err))
    },
    removeStudent(studentId) {
      axios.delete(`http://localhost:8080/api/v1/group/${this.groupId}/students/${studentId}`)
        .then(() => this.loadStudents())
        .catch(err => console.error(err))
    },
    formatDate(timestamp) {
      const date = new Date(timestamp);
      return date.toLocaleDateString(); 
    }
  }
}
</script>
