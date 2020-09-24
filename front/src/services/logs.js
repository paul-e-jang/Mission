import axios from 'axios'
import errorParser from '@/utils/error-parser'
import eventBus from '@/event-bus'

export default {

  fetchLogs () {
    return new Promise((resolve, reject) => {
      axios.get('/fetchLogs').then(({ data }) => {
        resolve(data)
        console.log(data)
        eventBus.$emit('logs', data)
      }).catch((error) => {
        reject(errorParser.parse(error))
      })
    })
  },
  writeLogs (detail) {
    return new Promise((resolve, reject) => {
      axios.post('/log', detail).then(({ data }) => {
        resolve(data)
      }).catch((error) => {
        reject(errorParser.parse(error))
      })
    })
  },
  viewedUpdate (id, how) {
    return new Promise((resolve, reject) => {
      axios.post('/view/' + id + '/' + how).then(({ data }) => {
        resolve(data)
      }).catch((error) => {
        reject(errorParser.parse(error))
      })
    })
  }
}
