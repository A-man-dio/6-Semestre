<?php

include_once '../repository/userRepository.php';

class UserController {

    private $userRepository = NULL;

    public function __construct() {
        $this->userRepository = new UserRepository();
    }
    
    public function login($username, $password) {
        $this->userRepository->login($username, $password);
    }
    
    public function addUser(User $user) {
        $this->userRepository->registarUser($user);
    }


    public function deleteUser($id) {
        $this->userRepository->deleteUser($id);
    }
}

