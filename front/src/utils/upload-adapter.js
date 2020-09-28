export default {

  upload (file) {
    return file => new Promise((resolve, reject) => {
      this._initRequest()
      this._initListeners(resolve, reject, file)
      this._sendRequest(file)
    })
  },

  abort () {
    if (this.xhr) {
      this.xhr.abort()
    }
  },

  _initRequest () {
    const xhr = this.xhr = new XMLHttpRequest()
    xhr.open('POST', 'http://localhost:8090/api/fileUpload', true)
    xhr.responseType = 'json'
  },

  _initListeners (resolve, reject, file) {
    const xhr = this.xhr
    const loader = this.loader
    const genericErrorText = `파일 업로드에 실패하였습니다.: ${file.name}.`

    xhr.addEventListener('error', () => reject(genericErrorText))
    xhr.addEventListener('abort', () => reject())
    xhr.addEventListener('load', () => {
      const response = xhr.response

      if (!response || response.error) {
        console.log(response.url)
        return reject(response && response.error ? response.error.message : genericErrorText)
      }
      resolve({
        default: response.url
      })
    })
    if (xhr.upload) {
      xhr.upload.addEventListener('progress', evt => {
        if (evt.lengthComputable) {
          loader.uploadTotal = evt.total
          loader.uploaded = evt.loaded
        }
      })
    }
  },

  _sendRequest (file) {
    const data = new FormData()
    data.append('upload', file)
    this.xhr.send(data)
  }
}
