#!/bin/bash

echo "#!/bin/bash" > curlGet.sh

if [ $# != 4 ]
then
   echo "Usage:  getIssues.sh <CSV file name> <userName> <password> <Jira URL (just the host and port)>"
   exit 1
fi

while read ISSUE
do
echo curl -u ${2}:${3} -i -H \"Accept: application/json\" -H \"Content-Type: application/json\" ${4}/rest/api/2/issue/${ISSUE}\?expand=changelog \> ${ISSUE}.tmp >> curlGet.sh
done < ${1}

cat curlGet.sh | sed -e 's///g' > curlGet1.sh
mv curlGet1.sh curl.sh
chmod 755 curl.sh

./curl.sh

for FILE in $(ls ${1%.csv}*.tmp)
do
echo ${FILE%.tmp}.json
cat ${FILE} | grep -E '^{' > ${FILE%.tmp}.json
done

rm *.tmp curlGet.sh
