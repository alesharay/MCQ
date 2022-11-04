#!/usr/bin/env bash
# file: exam_test.sh


# Run before `all` tests
function oneTimeSetUp() {
  return 0
}

# Run before `each` test
function setUp() {
  return 0
}

function testEquality() {
  assertEquals 1 1
}

# Run after `each` test
function tearDown() {
  return 0
}

# Run after `all` tests
function oneTimeTearDown() {
  return 0
}




source shunit2