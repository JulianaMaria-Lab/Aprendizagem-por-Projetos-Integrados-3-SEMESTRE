import { makeStyles } from '@material-ui/core/styles';

export default makeStyles((theme) => ({
    root: {
      display:'flex',
      flexDirection:'column',
      justifyContent:'center',
      backgroundColor: '#fff',
      padding: '2em'
    },
    text:{
        marginBottom:'2em'
    },
    button:{
      width:'2em'
      
    }
  }));