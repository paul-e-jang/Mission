<template>
<v-container>
    <v-data-table
      :items="desserts"
      :search="search"
      :sort-by="['created_date']"
      calculated-widths="true"
      :headers="headers"
      :loading="loading"
      :dense="dense"
      id="Logs"
    >
    <template v-slot:top>
      <div>
        <h2> Login / Logout 기록 </h2>
      <v-text-field
        v-model="search"
        append-icon="mdi-magnify"
        label="아이디 혹은 이름으로 검색하세요"
        single-line
        hide-details
        id="search"
      ></v-text-field>
      </div>
      </template>
      <template v-slot:body="{ items }">
        <tbody>
          <tr v-for="(item, index) in items" :key="index">
            <td>{{ index+1 }}</td>
            <td>
              {{ item.userCode }}
            </td>
            <td>
              {{ item.name }}
            </td>
            <td>{{ dateConvert(item.loggedAt) }}</td>
            <td>{{ dateConvert(item.logOuttedAt) }}</td>
          </tr>
        </tbody>
      </template>
      <template v-slot:progress>
        <v-progress-linear color="purple" :height="10" indeterminate></v-progress-linear>
      </template>
    </v-data-table>
</v-container>
</template>

<script>
import LogService from '@/services/log'
import DateParser from '@/utils/date-parser'
import { mdiDelete } from '@mdi/js'

export default {
  name: 'BoardView',
  components: {
  },
  mounted () {
    this.Fetch()
  },
  computed: {
    boardname () {
      return 'default'
    }
  },
  methods: {
    Fetch () {
      LogService.fetchlogs('default')
      this.$bus.$on('logs', (data) => {
        this.logs = data.logs
      })
    },
    dateConvert (date) {
      return DateParser.ParseRefactor(date)
    }
  },
  data () {
    return {
      mdiDelete,
      search: '',
      dense: false,
      loading: false,
      errorMessage: '',
      headers: [
        {
          text: '번호',
          sortable: true,
          value: 'no',
          width: '',
          align: 'center'
        },
        {
          text: '아이디',
          sortable: true,
          value: 'userCode',
          width: '',
          align: 'center'
        },
        {
          text: '이름',
          value: 'name',
          sortable: true,
          width: '',
          align: 'center'
        },
        {
          text: '로그인 시각',
          value: 'loggedAt',
          sortable: true,
          width: '',
          align: 'center'
        },
        {
          text: '로그아웃 시각',
          value: 'logOuttedAt',
          sortable: true,
          width: '',
          align: 'center'
        }
      ],
      logs: [],
      /* desserts: 개발용 mock 데이터 */
      desserts: [
        {
          no: '1',
          userCode: 'aslqqq',
          name: 'Frozen Yogurt',
          loggedAt: '22/35',
          logOuttedAt: '26/35',
          id: '32'
        },
        {
          no: '2',
          userCode: 'qalkqq',
          name: 'Yogurt',
          loggedAt: '22/35',
          logOuttedAt: '26/35',
          id: '32'
        }
      ]
    }
  }
}
</script>

<style scoped>
* {
  text-align: center;
}
#Logs {
  min-height: 75vh;
  padding: 10px;
  width: 100%;

}
#Logs td {
  padding-left: 0px;
}

#search {
  margin-bottom: 10px;
  width: 100px;
}
</style>
