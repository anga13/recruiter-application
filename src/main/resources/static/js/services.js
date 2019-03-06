import axios from 'axios'

export function getAllStatuses() {
  return axios('/application-status');
}

export function getAllCompetences() {
  return axios('/competences');
}

export function getAllApplications() {
  return axios('/applications');
}

export function getAllUsers() {
  return axios('/users');
}

export function createUser(user) {
  return axios.post('/users', user);
}

export function createApplication(application) {
  return axios.post('/applications', application);
}
