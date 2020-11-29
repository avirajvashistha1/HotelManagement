#!/usr/bin/env bash

set -euo pipefail
which psql > /dev/null || (echo "Please ensure that postgres client is in your PATH" && exit 1)

mkdir -p $HOME/docker/volumes/postgres
echo 'point 1'
rm -rf $HOME/docker/volumes/postgres/data
echo 'point 2'

docker run --rm --name pg-docker -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=dev -d -p 5432:5432 -v $HOME/docker/volumes/postgres:/var/lib/postgresql postgres
echo 'point 2.A'
sleep 10
echo 'point 3'
export PGPASSWORD=postgres
echo 'point 4'
psql -U postgres -d dev -h localhost -f schema.sql
psql -U postgres -d dev -h localhost -f data.sql
echo 'point 5'