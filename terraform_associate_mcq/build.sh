#!/usr/bin/env bash

docker build -t quiz .
echo
echo "generating quiz..."
docker run --privileged -it --rm -v $(pwd):/app quiz