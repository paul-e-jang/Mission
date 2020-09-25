export default {
  ParseRefactor (date) {
    let regDateTimestamp = ''
    if (date !== null) {
      regDateTimestamp = new Date(date)
    }
    return regDateTimestamp
  }

}
