var baseURL =
  "https://github.com/giancosta86/HistoryMark/releases/latest"



function onMobileDevice() {
  return window.screen.availWidth < 840
}


window.onload = function() {
  if (!onMobileDevice()) {
    setupRunWithMoonDeployButton()
    setupDownloadBinaryZipButton()
  }
}



function setupRunWithMoonDeployButton() {
  getLatestMoonDescriptor(
    baseURL,

    "App.moondeploy",

    function(descriptorURL) {
      var runButton = document.getElementById("runApp")
      runButton.href = descriptorURL
      runButton.style.display = "inline-block"
    },

    function(statusCode) {
      console.log("Error while retrieving the MoonDeploy descriptor")
      console.log(statusCode)
    }
  )
}



function setupDownloadBinaryZipButton() {
  getLatestReleaseArtifact(
    baseURL,

    "HistoryMark",

    ".zip",

    function(zipURL) {
      var downloadBinaryZipButton = document.getElementById("downloadApp")
      downloadBinaryZipButton.href = zipURL
      downloadBinaryZipButton.style.display = "inline-block"
    },

    function(statusCode) {
      console.log("Error while retrieving the binary zip artifact")
      console.log(statusCode)
    }
  )
}
